Gerrit.install(function(self) {
  function getCurrentUser(url) {
    var karmaUserEmail = getKarmaUserEmail();

    /*self.get('/plugins/karma?account_id=' + currentAccountId, function(result) {
      console.log('rest call result is:', result);
    });
    if (url.indexOf('/dashboard/') > -1 || url.indexOf('/q/') > -1 ) {
      console.log(document.getElementsByClassName('changeTable'));
    }*/
    updateKarmaValue();
    console.log(self.getPluginName());
  }
  function getKarmaUserEmail() {
    var cookies = document.cookie.split(';');
    for(var i = 0; i < cookies.length; i++) {
      cookies[i] = cookies[i].trim();
      if (cookies[i].split('=')[0] === 'karma_user_email') {
        console.log('cookie value', cookies[i].split('=')[1]);
        return cookies[i].split('=')[1];
      }
    }
  }
  function updateKarmaValue() {
    var gerritTopMenuCont = $('#gerrit_topmenu');
    var gerritTopMenu = $('#gerrit_topmenu .topmenu');
    gerritTopMenu.css('padding-left', '200px');

    $('#karma-details').remove();
    var karmaRating = gerritTopMenuCont.append('<div id="karma-details">300</div>');
    $('#karma-details').css('position', 'absolute');
    $('#karma-details').css('padding-left', '20px');
    $('#karma-details').css('top', '10px');
    $('#karma-details').css('width', '180px');
    $('#karma-details').css('background-color', 'beige');
    $('#karma-details').css('height', '40px');
  }
  self.on('history', getCurrentUser);
});