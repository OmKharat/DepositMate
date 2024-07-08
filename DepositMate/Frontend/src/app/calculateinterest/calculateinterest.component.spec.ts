import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { CalculateInterestComponent } from './calculateinterest.component';

describe('CalculateInterestComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule
      ],
      declarations: [
        CalculateInterestComponent
      ],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(CalculateInterestComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'deposit'`, () => {
    const fixture = TestBed.createComponent(CalculateInterestComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('deposit');
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(CalculateInterestComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('h1')?.textContent).toContain('Hello, deposit');
  });
});
