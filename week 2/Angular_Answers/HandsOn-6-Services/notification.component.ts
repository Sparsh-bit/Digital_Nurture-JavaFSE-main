import { Component } from '@angular/core';
import { NotificationService } from '../../services/notification.service';

@Component({
    selector: 'app-notification',
    template: `<p>Notifications Active!</p>`,
    // Providing at the component level creates a new, separate instance 
    // scoped specifically to this component and its children, bypassing the root singleton!
    providers: [NotificationService] 
})
export class NotificationComponent {
    constructor(private notificationService: NotificationService) {}
}