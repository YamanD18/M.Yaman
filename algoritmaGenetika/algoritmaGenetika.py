import random

# =========================================
# DATA PENJADWALAN
# =========================================

teachers = ['Guru A', 'Guru B', 'Guru C']

subjects = [
    'Matematika',
    'Fisika',
    'Kimia'
]

classes = [
    'Kelas 1',
    'Kelas 2',
    'Kelas 3'
]

timeslots = [
    'Senin P1',
    'Senin P2',
    'Selasa P1',
    'Selasa P2'
]

# =========================================
# MEMBUAT INDIVIDU / KROMOSOM
# FORMAT:
# [guru, mata pelajaran, kelas, waktu]
# =========================================

def create_individual():

    return [
        random.choice(teachers),
        random.choice(subjects),
        random.choice(classes),
        random.choice(timeslots)
    ]


# =========================================
# FUNGSI FITNESS
# MENGHITUNG JUMLAH BENTROK
# =========================================

def fitness(individual, schedule):

    conflicts = 0

    for item in schedule:

        # Bentrok jika kelas dan waktu sama
        if (
            individual[2] == item[2]
            and individual[3] == item[3]
        ):
            conflicts += 1

        # Bentrok jika guru dan waktu sama
        if (
            individual[0] == item[0]
            and individual[3] == item[3]
        ):
            conflicts += 1

    return conflicts


# =========================================
# SELEKSI
# MEMILIH 2 INDIVIDU TERBAIK
# =========================================

def selection(population, schedule):

    sorted_population = sorted(
        population,
        key=lambda ind: fitness(ind, schedule)
    )

    return sorted_population[:2]


# =========================================
# CROSSOVER
# PERTUKARAN GEN ANTAR PARENT
# =========================================

def crossover(parent1, parent2):

    crossover_point = random.randint(1, 3)

    child1 = (
        parent1[:crossover_point]
        + parent2[crossover_point:]
    )

    child2 = (
        parent2[:crossover_point]
        + parent1[crossover_point:]
    )

    return child1, child2


# =========================================
# MUTASI
# MENGUBAH SALAH SATU GEN SECARA ACAK
# =========================================

def mutate(individual):

    mutation_point = random.randint(0, 3)

    if mutation_point == 0:
        individual[0] = random.choice(teachers)

    elif mutation_point == 1:
        individual[1] = random.choice(subjects)

    elif mutation_point == 2:
        individual[2] = random.choice(classes)

    else:
        individual[3] = random.choice(timeslots)

    return individual


# =========================================
# ALGORITMA GENETIKA UTAMA
# =========================================

def genetic_algorithm():

    population_size = 10
    generations = 10

    # Membuat populasi awal
    population = [
        create_individual()
        for _ in range(population_size)
    ]

    schedule = []

    # Perulangan generasi
    for generation in range(generations):

        new_population = []

        # Seleksi dan reproduksi
        for _ in range(population_size // 2):

            parent1, parent2 = selection(
                population,
                schedule
            )

            child1, child2 = crossover(
                parent1,
                parent2
            )

            child1 = mutate(child1)
            child2 = mutate(child2)

            new_population.extend([
                child1,
                child2
            ])

        population = new_population

        # Memilih individu terbaik
        best_individual = min(
            population,
            key=lambda ind: fitness(ind, schedule)
        )

        schedule.append(best_individual)

        print(
            f"Generasi {generation + 1}"
        )

        print(
            f"Individu Terbaik: {best_individual}"
        )

        print(
            f"Fitness: "
            f"{fitness(best_individual, schedule)}"
        )

        print("-" * 40)

    # =====================================
    # MENAMPILKAN HASIL AKHIR
    # =====================================

    print("\nJADWAL AKHIR")

    for item in schedule:

        print(
            f"{item[2]} | "
            f"{item[1]} | "
            f"{item[0]} | "
            f"{item[3]}"
        )


# =========================================
# MENJALANKAN PROGRAM
# =========================================

genetic_algorithm()