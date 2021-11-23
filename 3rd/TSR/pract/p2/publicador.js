const { socket } = require('zeromq');

const [_, __, port, nMessages, ...topics] = process.argv;

const pub = socket('pub').bind('tcp://*:' + port);
const sub = socket('sub').connect('tcp://127.0.0.1:' + port)
  .subscribe('')
  .on('message', (m) => console.log(m.toString()));

const topicsHistory = topics.map((topic) => ({
  label: topic,
  counter: 1
}));

let seconds = 1;

const emitMsg = () => {
  const topic = topicsHistory[0];

  /* Laziness: check first the content is the expected */
  /* console.log(`${seconds}: ${topic.label} ${topic.counter++}`); */

  pub.send(`${seconds}: ${topic.label} ${topic.counter++}`);
  topicsHistory.shift(); 
  topicsHistory.push(topic); 
}

const intervalId = setInterval(() => {
  emitMsg();

  if (seconds === parseInt(nMessages)) {
    /* Allow sub to receive last message before end. */
    setTimeout(() => {
      clearInterval(intervalId);
      console.log('Program finished');
      pub.close();
      sub.close();
      process.exit(0);
    }, 500);    
  }

  seconds++;
}, 1000);
