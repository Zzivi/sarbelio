$ ->
  $.get "/ingredients", (ingredients) ->
    $.each ingredients, (index, ingredient) ->
      $("#ingredients").append $("<li>").text ingredient.name