import { TestBed } from '@angular/core/testing';

import { SearchByVehicleService } from './search-by-vehicle.service';

describe('SearchByVehicleService', () => {
  let service: SearchByVehicleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SearchByVehicleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
