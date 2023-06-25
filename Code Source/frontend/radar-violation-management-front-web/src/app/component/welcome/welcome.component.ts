import { Component } from '@angular/core';
import {AuthentificationsService} from "../../services/authentifications.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent {
  constructor(public authenticatUser:AuthentificationsService,private router:Router) {
  }
}
