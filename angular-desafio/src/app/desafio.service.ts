import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DesafioService {

  desafioUrl = 'http://localhost:8080/palavras/';

  constructor(private http: HttpClient) { }

  listar(){
    return this.http.get<any[]>(`${this.desafioUrl}`);
    //return this.http.get<Array<any>>(this.desafioUrl);
  }

  validarPalavra(palavra: string){
    return this.http.post(this.desafioUrl, palavra);
  }
}
