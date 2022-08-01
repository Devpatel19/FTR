import { TestBed } from '@angular/core/testing';

import { SearchByUserService } from './search-by-user.service';

describe('SearchByUserService', () => {
  let service: SearchByUserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SearchByUserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
