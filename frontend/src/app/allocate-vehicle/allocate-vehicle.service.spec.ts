import { TestBed } from '@angular/core/testing';

import { AllocateVehicleService } from './allocate-vehicle.service';

describe('AllocateVehicleService', () => {
  let service: AllocateVehicleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AllocateVehicleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
