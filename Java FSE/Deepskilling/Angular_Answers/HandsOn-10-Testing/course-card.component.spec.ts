import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CourseCardComponent } from './course-card.component';
import { By } from '@angular/platform-browser';

describe('CourseCardComponent', () => {
    let component: CourseCardComponent;
    let fixture: ComponentFixture<CourseCardComponent>;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            declarations: [CourseCardComponent]
        }).compileComponents();

        fixture = TestBed.createComponent(CourseCardComponent);
        component = fixture.componentInstance;
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });

    it('should display course name correctly', () => {
        component.course = { id: 1, name: 'Data Structures', code: 'CS101', credits: 4, gradeStatus: 'passed' };
        // Detect changes updates the DOM with the new input data
        fixture.detectChanges();

        // By.css() is the preferred Angular testing utility over document.querySelector!
        const h3 = fixture.debugElement.query(By.css('h3')).nativeElement;
        expect(h3.textContent).toContain('Data Structures');
    });

    it('should emit enrollRequested event when button is clicked', () => {
        component.course = { id: 1, name: 'Data Structures', code: 'CS101', credits: 4, gradeStatus: 'passed' };
        fixture.detectChanges();
        
        spyOn(component.enrollRequested, 'emit');
        
        const button = fixture.debugElement.query(By.css('button')).nativeElement;
        button.click();
        fixture.detectChanges();
        
        expect(component.enrollRequested.emit).toHaveBeenCalledWith(1);
    });
});