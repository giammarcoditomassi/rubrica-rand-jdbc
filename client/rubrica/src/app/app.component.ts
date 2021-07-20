import { Contatto } from './contatto';
import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  contatto: Contatto = new Contatto();
  contatti: Contatto[] = [];

  constructor(private http: HttpClient) {
    // recuperare da server la lista dei contatti
    let ox: Observable<Contatto[]> =
      http.get<Contatto[]>("http://localhost:8080/mostra-contatti");
    ox.subscribe(u => this.contatti = u);
  }

  aggiungi() {
    console.log('Siamo su aggiungi contatto');
    if (this.contatto.nome) {
      let ox: Observable<Contatto[]> =
        this.http.post<Contatto[]>("http://localhost:8080/aggiungi", this.contatto);
      ox.subscribe(u => this.contatti = u);
      this.contatto.nome = "";
    }
  }

  rimuovi(r: Contatto) {
    console.log('Siamo in rimuovi contatto', r);
    let ox: Observable<Contatto[]> =
      this.http.post<Contatto[]>("http://localhost:8080/rimuovi", r);
    ox.subscribe(u => this.contatti = u);
  }
}