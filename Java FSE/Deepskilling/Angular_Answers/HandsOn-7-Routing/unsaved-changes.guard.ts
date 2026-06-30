import { Injectable } from '@angular/core';
import { CanDeactivate } from '@angular/router';

export interface CanComponentDeactivate {
    canDeactivate: () => boolean;
}

@Injectable({ providedIn: 'root' })
export class UnsavedChangesGuard implements CanDeactivate<CanComponentDeactivate> {
    canDeactivate(component: CanComponentDeactivate): boolean {
        // If the component returns false (meaning it's dirty), show the prompt!
        if (!component.canDeactivate()) {
            return window.confirm('You have unsaved changes. Leave?');
        }
        return true;
    }
}