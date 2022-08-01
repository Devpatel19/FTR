import { TestBed } from '@angular/core/testing';

import { CreateWorkitemService } from './create-workitem.service';

describe('CreateWorkitemService', () => {
  let service: CreateWorkitemService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateWorkitemService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
