import { Injectable } from '@angular/core';
import { Course } from '../models/course.model';

@Injectable({
    providedIn: 'root'
})
export class CourseService {
    private courses: Course[] = [
        { id: 1, name: 'Angular Basics', code: 'CS101', credits: 3, gradeStatus: 'passed' },
        { id: 2, name: 'Advanced TypeScript', code: 'CS102', credits: 4, gradeStatus: 'pending' },
        { id: 3, name: 'RxJS Masterclass', code: 'CS103', credits: 3, gradeStatus: 'failed' },
        { id: 4, name: 'NgRx State Management', code: 'CS201', credits: 5, gradeStatus: 'pending' },
        { id: 5, name: 'Angular Unit Testing', code: 'CS202', credits: 2, gradeStatus: 'pending' }
    ];

    getCourses(): Course[] {
        return this.courses;
    }

    getCourseById(id: number): Course | undefined {
        return this.courses.find(c => c.id === id);
    }

    addCourse(course: Course): void {
        this.courses.push(course);
    }
}