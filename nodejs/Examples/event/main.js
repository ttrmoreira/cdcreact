var events = require('events');
var eventEmitter = new events.EventEmitter();

//listener 1
var listener1 = function listener1(){
	console.log('listener1 executed');
}

//listener 2
var listener2 = function listener2(){
	console.log('listener2 executed');
}

var listener3 = function listener3(){
	console.log('listener3 executed');
}

//Bind the connection event with the listener1 function
eventEmitter.addListener('connection',listener1);
//Bind the connection event with the listener2 function
eventEmitter.addListener('connection',listener2);

var eventListeners = require('events').EventEmitter.listenerCount(eventEmitter,'connection');
console.log (eventListeners + " Listener(s) listening to connection event");

//Fire the connection event
eventEmitter.emit('connection');

//Remove the binding of listener1 function
eventEmitter.removeListener('connection',listener1);
console.log('Listener1 will not listen now');

//Fire the connection event
eventEmitter.emit('connection');

eventListeners = require('events').EventEmitter.listenerCount(eventEmitter,'connection');
console.log (eventListeners + " Listener(s) listening to connection event");

//Bind the connection event with the listener3 function
eventEmitter.addListener('connection', listener3);

//Fire the connection event
eventEmitter.emit('connection');

console.log('Program Ended');