import { TestBed } from '@angular/core/testing';

import { ViewWorkitemsService } from './view-workitems.service';

describe('ViewWorkitemsService', () => {
  let service: ViewWorkitemsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViewWorkitemsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
