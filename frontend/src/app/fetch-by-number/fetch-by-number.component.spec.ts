import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FetchByNumberComponent } from './fetch-by-number.component';

describe('FetchByNumberComponent', () => {
  let component: FetchByNumberComponent;
  let fixture: ComponentFixture<FetchByNumberComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FetchByNumberComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FetchByNumberComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
