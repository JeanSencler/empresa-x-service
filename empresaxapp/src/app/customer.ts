import { Address } from "./address";

export class Customer {
  customerid !: BigInt;
  firstname !: string;
  lastname !: string;
  state !: string;
  address !: Array<Address>;
}
