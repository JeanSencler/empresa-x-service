import { Address } from "./address";

export class Customer {
  customerId !: BigInt;
  firstName !: string;
  lastName !: string;
  state !: string;
  address !: Array<Address>;
}
