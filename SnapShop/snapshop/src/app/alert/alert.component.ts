import { Component, OnInit } from '@angular/core';

import { AlertService } from '../../service/alert.service';

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.scss'],
  providers:[AlertService]
})
export class AlertComponent {
  message: any;

  constructor(private alertService: AlertService) { }

  ngOnInit() {
      this.alertService.getMessage().subscribe(message => { this.message = message; });
  }
}
