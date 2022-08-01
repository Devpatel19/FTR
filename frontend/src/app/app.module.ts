import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { CreateUserProfileComponent } from './create-user-profile/create-user-profile.component';
import { ViewUserProfileComponent } from './view-user-profile/view-user-profile.component';
import {ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UpdateUserProfileComponent } from './update-user-profile/update-user-profile.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AssignTerminalComponent } from './assign-terminal/assign-terminal.component';
import { WorkitemsComponent } from './workitems/workitems.component';
import { AllocateVehicleComponent } from './allocate-vehicle/allocate-vehicle.component';
import { SearchByVehicleComponent } from './search-by-vehicle/search-by-vehicle.component';
import { SearchByUserComponent } from './search-by-user/search-by-user.component';
import { UpdateStatusComponent } from './update-status/update-status.component';
import { ViewWorkitemsComponent } from './view-workitems/view-workitems.component';
import { CreateWorkitemComponent } from './create-workitem/create-workitem.component';
import { AddTerminalComponent } from './add-terminal/add-terminal.component';
import { TerminalDetailsComponent } from './terminal-details/terminal-details.component';


import { VehicleHomeComponent } from './vehicle-home/vehicle-home.component';
import { FetchAllVehiclesComponent } from './fetch-all-vehicles/fetch-all-vehicles.component';
import { FetchByNameComponent } from './fetch-by-name/fetch-by-name.component';
import { FetchByNumberComponent } from './fetch-by-number/fetch-by-number.component';
import { RemoveVehicleComponent } from './remove-vehicle/remove-vehicle.component';
import { UpdateVehicleStatusComponent } from './update-vehicle-status/update-vehicle-status.component';
import { InsertVehicleComponent } from './insert-vehicle/insert-vehicle.component';
import { DatePipe } from '@angular/common';




@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CreateUserProfileComponent,
    ViewUserProfileComponent,
    UpdateUserProfileComponent,
    LandingPageComponent,
    LoginAdminComponent,
    AdminDashboardComponent,
    AssignTerminalComponent,
    WorkitemsComponent,
    AllocateVehicleComponent,
    SearchByVehicleComponent,
    SearchByUserComponent,
    UpdateStatusComponent,
    ViewWorkitemsComponent,
    CreateWorkitemComponent,
    AddTerminalComponent,
    AddTerminalComponent,
    TerminalDetailsComponent,
    VehicleHomeComponent,
    FetchAllVehiclesComponent,
    FetchByNameComponent,
    FetchByNumberComponent,
    RemoveVehicleComponent,
    UpdateVehicleStatusComponent,
    InsertVehicleComponent
 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
   
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
