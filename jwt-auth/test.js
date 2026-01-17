const jwt = require('jsonwebtoken');
const secretKey = 'rahasia';

const user = {
  id: 1,
  username: 'M Yaman Darawan'
};

const token = jwt.sign(user, secretKey, { expiresIn: '30s' });
console.log('Token:', token);
