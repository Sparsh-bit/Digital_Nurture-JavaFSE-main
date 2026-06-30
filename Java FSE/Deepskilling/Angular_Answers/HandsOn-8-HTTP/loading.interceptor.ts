import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';
import { LoadingService } from './loading.service';

@Injectable()
export class LoadingInterceptor implements HttpInterceptor {
    constructor(private loadingService: LoadingService) {}

    intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
        this.loadingService.setLoading(true);
        
        return next.handle(request).pipe(
            // finalize runs whether the observable completes successfully or errors out.
            // This guarantees our loading spinner will never get permanently stuck on screen!
            finalize(() => this.loadingService.setLoading(false))
        );
    }
}