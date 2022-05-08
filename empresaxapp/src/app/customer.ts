import { Address } from "./address";

export class Customer {
  customerId !: number;
  firstName !: string;
  lastName !: string;
  state !: string;
  address !: Array<Address>;
}
