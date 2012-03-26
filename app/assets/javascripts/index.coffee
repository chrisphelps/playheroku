$ ->
  $.get "/foos.json", (data) ->
    $.each data, (index, foo) ->
      $("#foos").append "<li>" + foo.name + "</li>"
			