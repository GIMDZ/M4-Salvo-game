//Ajax call

var urlUsers = '/api/games';
var app = new Vue({

        el: '#app',
        created: function () {
            this.getUsers();
        },

        data: {
            lists: [],
            /*players: []
*/
        },

        methods: {
            getUsers: function () {
                this.$http.get(urlUsers).then(function (response) {
                    this.lists = response.data;
                    /*this.players = lists.gamePlayers;*/
                });
            }
        }
    }
)

