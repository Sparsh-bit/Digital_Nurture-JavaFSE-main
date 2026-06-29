$(document).ready(function() {
    
    let isVisible = true;

    // Use jQuery click handler
    $('#toggleBtn').click(function() {
        if (isVisible) {
            // Use jQuery fadeOut animation
            $('#card').fadeOut('fast');
        } else {
            // Use jQuery fadeIn animation
            $('#card').fadeIn('fast');
        }
        isVisible = !isVisible;
    });

});