import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchByVehicleComponent } from './search-by-vehicle.component';

describe('SearchByVehicleComponent', () => {
  let component: SearchByVehicleComponent;
  let fixture: ComponentFixture<SearchByVehicleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchByVehicleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchByVehicleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
