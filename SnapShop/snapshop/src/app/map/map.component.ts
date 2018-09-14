import { Component } from '@angular/core';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss']
})
export class MapComponent {
  title = 'app';
  lat: number = 42.344694;
  lng: number = -71.099255;

  markers: marker[]= [
    {
      name:'Target',
      lat:  42.344694,
      lng: -71.099255,
      draggable: false
    },
    {
      name:'Target',
      lat:  42.350603,
      lng: -71.114053,
      draggable: false
    }
    
  ];
  constructor(){

  }
}
interface marker{
  name?:string;
  lat:number;
  lng:number;
  draggable:false;
}