import { Timestamp } from './timestamp';

export class Subject extends Timestamp {
  id: number;
  name: string;
  price: number;
  active: boolean;
  level: string;

  constructor(obj?: Subject) {
    super(obj);
    if (obj) {
      this.id = obj.id;
    }
  }
}
