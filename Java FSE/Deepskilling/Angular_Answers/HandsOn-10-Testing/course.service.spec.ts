import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { CourseService } from './course.service';

describe('CourseService', () => {
    let service: CourseService;
    let httpMock: HttpTestingController;

    beforeEach(() => {
        TestBed.configureTestingModule({
            imports: [HttpClientTestingModule],
            providers: [CourseService]
        });
        service = TestBed.inject(CourseService);
        httpMock = TestBed.inject(HttpTestingController);
    });

    afterEach(() => {
        // verify() ensures that no unexpected HTTP requests were fired during the test!
        httpMock.verify();
    });

    it('should retrieve courses via GET', () => {
        const mockCourses = [{ id: 1, name: 'Test Course', code: 'TC1', credits: 3, gradeStatus: 'pending' as any }];

        service.getCourses().subscribe(courses => {
            expect(courses.length).toBe(1);
            expect(courses).toEqual(mockCourses);
        });

        const req = httpMock.expectOne('http://localhost:3000/courses');
        expect(req.request.method).toBe('GET');
        req.flush(mockCourses);
    });
});