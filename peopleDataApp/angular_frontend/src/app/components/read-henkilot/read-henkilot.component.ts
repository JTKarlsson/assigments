import { Component } from '@angular/core';
import {HenkiloService} from '../../services/henkilo.service';

@Component({
  selector: 'app-read-henkilot',
  templateUrl: './read-henkilot.component.html',
  styleUrls: ['./read-henkilot.component.scss']
})
export class ReadHenkilotComponent {
  constructor(private henkiloService: HenkiloService) {}
  jsonData: any[] = [];

  ngOnInit() {
    this.henkiloService.getItems().subscribe(data => {
      this.jsonData = data;
    });
  }
}
