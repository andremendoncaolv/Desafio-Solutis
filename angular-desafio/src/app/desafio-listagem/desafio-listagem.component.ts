import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

import { DesafioService } from '../desafio.service';

@Component({
  selector: 'app-desafio-listagem',
  templateUrl: './desafio-listagem.component.html',
  styleUrls: ['./desafio-listagem.component.css']
})
export class DesafioListagemComponent implements OnInit {

  palavras : Array<any>;
  palavra: any;

  constructor(private desafioService: DesafioService) {}

  ngOnInit() {
    this.palavra = {};
    
    this.desafioService.listar()
      .subscribe(dados => this.palavras = dados);
  }

  validarPalavra(frm: FormGroup){
    this.desafioService.validarPalavra(this.palavra).subscribe(resposta => {
      this.palavras.push(resposta);

      frm.reset();
    });
  }
}
