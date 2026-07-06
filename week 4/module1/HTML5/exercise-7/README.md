# Exercise 7: Video Invite and Media Events

I set up a promo video page for the community.

I used the HTML5 `<video>` tag with the `controls` attribute so the user can actually play and pause it. I hooked up the `oncanplay` event so that as soon as the browser buffers enough data to start playing, it changes the "Loading..." text to "Video ready to play!". (I used a standard test MP4 from w3schools so it actually works when you open it).

I also added a mock RSVP form underneath. If you type anything into the name field, a JavaScript variable flags the page as "dirty". If you try to click the link to leave the page or close the tab, the `window.onbeforeunload` event intercepts you and asks if you are sure you want to leave without saving. (Note: Chrome shows a generic warning box for security reasons, it won't show custom text anymore).
