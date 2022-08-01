import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddTerminalComponent } from './add-terminal/add-terminal.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AllocateVehicleComponent } from './allocate-vehicle/allocate-vehicle.component';
import { AssignTerminalComponent } from './assign-terminal/assign-terminal.component';
import { CreateUserProfileComponent } from './create-user-profile/create-user-profile.component';
import { CreateWorkitemComponent } from './create-workitem/create-workitem.component';
import { FetchAllVehiclesComponent } from './fetch-all-vehicles/fetch-all-vehicles.component';
import { FetchByNameComponent } from './fetch-by-name/fetch-by-name.component';
import { FetchByNumberComponent } from './fetch-by-number/fetch-by-number.component';
import { InsertVehicleComponent } from './insert-vehicle/insert-vehicle.component';

import { LandingPageComponent } from './landing-page/landing-page.component';
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { LoginGuardService } from './login-guard.service';
import { LoginComponent } from './login/login.component';
import { RemoveVehicleComponent } from './remove-vehicle/remove-vehicle.component';

import { SearchByUserComponent } from './search-by-user/search-by-user.component';
import { SearchByVehicleComponent } from './search-by-vehicle/search-by-vehicle.component';
import { TerminalDetailsComponent } from './terminal-details/terminal-details.component';
import { UpdateStatusComponent } from './update-status/update-status.component';
import { UpdateUserProfileComponent } from './update-user-profile/update-user-profile.component';
import { UpdateVehicleStatusComponent } from './update-vehicle-status/update-vehicle-status.component';
import { VehicleHomeComponent } from './vehicle-home/vehicle-home.component';
import { ViewTerminalComponent } from './view-terminal/view-terminal.component';
import { ViewUserProfileComponent } from './view-user-profile/view-user-profile.component';
import { ViewWorkitemsComponent } from './view-workitems/view-workitems.component';
import { WorkitemsComponent } from './workitems/workitems.component';

const routes: Routes = [
  
  {path: 'FTR',component:LandingPageComponent},
  {path: '' , redirectTo:'/FTR',pathMatch: 'full'},
  {path: 'admin' ,component: LoginAdminComponent },
    {path: 'login', component: LoginComponent},
    {path: 'userProfile', component: CreateUserProfileComponent},
    {path: 'viewUserProfile/:id', component: ViewUserProfileComponent},
    {path: 'updateUserProfile/:id', component: UpdateUserProfileComponent},
    {path:'admin/dashboard' , component: AdminDashboardComponent},

    {path:'admin/dashboard/workitems',component:WorkitemsComponent},
  {path:'admin/dashboard/workitems/register',component:CreateWorkitemComponent},
  {path:'admin/dashboard/workitems/searchbyvehicle',component:SearchByVehicleComponent},
  {path:'admin/dashboard/workitems/searchbyuser',component:SearchByUserComponent},
  {path:'admin/dashboard/workitems/assign',component:AssignTerminalComponent},
  {path:'admin/dashboard/workitems/allocation',component:AllocateVehicleComponent},
  {path:'admin/dashboard/workitems/view',component:ViewWorkitemsComponent},
  {path:'admin/dashboard/workitems/update',component:UpdateStatusComponent},


  {path:'admin/dashboard/terminal',component:TerminalDetailsComponent},
  {path:'terminal/:id',component:ViewTerminalComponent},
  {path:'addterminal',component:AddTerminalComponent},



  { path: 'admin/dashboard/vehicle',  component: VehicleHomeComponent },

  { path: 'fetchAll',  component: FetchAllVehiclesComponent },
{ path: 'fetchByName',  component: FetchByNameComponent },
{ path: 'fetchByNumber',  component: FetchByNumberComponent },
{ path: 'delete',  component: RemoveVehicleComponent },
{ path: 'insert',  component: InsertVehicleComponent },
{ path: 'update',  component: UpdateVehicleStatusComponent }

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
