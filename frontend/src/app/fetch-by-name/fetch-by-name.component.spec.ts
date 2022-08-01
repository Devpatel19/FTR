import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FetchByNameComponent } from './fetch-by-name.component';

describe('FetchByNameComponent', () => {
  let component: FetchByNameComponent;
  let fixture: ComponentFixture<FetchByNameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FetchByNameComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FetchByNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
