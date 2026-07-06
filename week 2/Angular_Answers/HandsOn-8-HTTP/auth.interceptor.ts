import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
    intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
        const clonedRequest = request.clone({
            setHeaders: {
                Authorization: 'Bearer mock-token-12345'
            }
        });
        return next.handle(clonedRequest);
    }
}