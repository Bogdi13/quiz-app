export class User {
  id: number;
  firstName: string;
  lastName: string;
  username: string;
  password: string;
  role: string;

  constructor(user: any = {}){
    this.id = user.id,
    this.firstName = user.firstName,
    this.lastName = user.lastName,
    this.username = user.username,
    this.password = user.password,
    this.role = user.role
  }
}