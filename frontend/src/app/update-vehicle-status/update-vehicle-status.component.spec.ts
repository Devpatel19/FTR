import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateVehicleStatusComponent } from './update-vehicle-status.component';

describe('UpdateVehicleStatusComponent', () => {
  let component: UpdateVehicleStatusComponent;
  let fixture: ComponentFixture<UpdateVehicleStatusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateVehicleStatusComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateVehicleStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
