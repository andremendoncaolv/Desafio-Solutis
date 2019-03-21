import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DesafioListagemComponent } from './desafio-listagem.component';

describe('DesafioListagemComponent', () => {
  let component: DesafioListagemComponent;
  let fixture: ComponentFixture<DesafioListagemComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DesafioListagemComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DesafioListagemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
