import axios from 'axios'
export const SHOW_VUELOS = 'SHOW_VUELOS'
export const SHOW_USERS = 'SHOW_USERS'

/**
 * Carga lista de usuarios
 */
export function showUsers() {
    
    return (dispatch, getState) => {
        axios.get('http://jsonplaceholder.typicode.com/users')
            .then((response) => {
                console.log(response)
                dispatch( { type: SHOW_USERS, payload: response.data } ) 
            }) 
    }
    
}

/**
 * Carga la lista de vuelos por archivo json
 */
export function showVuelos() {

    return (dispatch, getState) => {
        axios.get(urlFunction())
            .then((response) => {
                console.log(response.log)
                dispatch({ type: SHOW_VUELOS, payload: response.data })
            })
    }

}

/**
 * url que provee los datos para poblar la tabla
 */
function urlFunction() {
    //return 'http://localhost:8090/ws/vuelos';
    return 'http://localhost:8080/vuelos.json';
}

/**
 * Carga lista de vuelos por servicio web spring boot java
 */
/*export function showVuelos() {
    
        return (dispatch, getState) => {
            axios.get('http://localhost:8090/ws/vuelos')
                .then((response) => {
                    console.log(response)
                    dispatch({ type: SHOW_VUELOS, payload: response.data })
                })
        }
    
}*/


