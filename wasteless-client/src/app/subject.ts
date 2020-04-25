import { Observer } from './observer';

export interface Subject{
    
    registerObserver(o: Observer);

    removeObserver(o: Observer);

    notifyObservers();
}