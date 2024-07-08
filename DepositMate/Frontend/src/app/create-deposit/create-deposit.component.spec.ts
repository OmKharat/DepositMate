import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { CreateDepositComponent } from './create-deposit.component';

describe('CreateDepositComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule
      ],
      declarations: [
        CreateDepositComponent
      ],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(CreateDepositComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'my-deposit2'`, () => {
    const fixture = TestBed.createComponent(CreateDepositComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('my-deposit2');
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(CreateDepositComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('h1')?.textContent).toContain('Hello, my-deposit2');
  });
});
