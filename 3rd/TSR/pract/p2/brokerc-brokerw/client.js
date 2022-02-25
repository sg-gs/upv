const { randomBytes } = require('crypto');
const zmq = require('zeromq');
let req = zmq.socket('req');
req.connect('tcp://localhost:9998');

let exitCode = 0;

req.on('message', (msg) => {
  console.log('Respuesta recibida: %s', msg);
});

req.on('error', (err) => {
  console.log('ERROR %s', err.message);
  console.log(err);
  exitCode = 1;
  process.emit('SIGINT');
});

const messagesIntervalId = setInterval(() => {
  req.send(randomBytes(6).toString('hex'));
}, 1000);

process.on('SIGINT', () => {
  req.close();
  clearInterval(messagesIntervalId);
  process.exit(exitCode);
});
