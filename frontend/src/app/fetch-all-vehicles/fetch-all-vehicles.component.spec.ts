import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FetchAllVehiclesComponent } from './fetch-all-vehicles.component';

describe('FetchAllVehiclesComponent', () => {
  let component: FetchAllVehiclesComponent;
  let fixture: ComponentFixture<FetchAllVehiclesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FetchAllVehiclesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FetchAllVehiclesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
