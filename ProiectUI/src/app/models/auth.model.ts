export class AuthModel {
  username: string;
  password: string;

  constructor(user: any = {}){
    this.username = user.username,
    this.password = user.password
  }
}