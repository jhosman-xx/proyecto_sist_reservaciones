import axios from 'axios'
export const SHOW_VUELOS = 'SHOW_VUELOS'
export const SHOW_USERS = 'SHOW_USERS'
export const SHOW_RESERVAS = 'SHOW_RESERVAS'


/**
 * url que provee los vuelos para poblar la tabla
 */
function urlVuelosFunction() {
    //return 'http://localhost:8090/ws/vuelos';
    return 'http://localhost:8080/vuelos.json';
}

/**
 * url que provee los reservas para poblar la tabla
 */
function urlReservasFunction() {
    //return 'http://localhost:8090/ws/reservas';
    return 'http://localhost:8080/reservas.json';
}

/**
 * Carga lista de usuarios
 */
export function showUsers() {

    return (dispatch, getState) => {
        axios.get('http://jsonplaceholder.typicode.com/users')
            .then((response) => {
                console.log(response)
                dispatch({ type: SHOW_USERS, payload: response.data })
            })
    }

}

/**
 * Carga la lista de vuelos por archivo json
 */
export function showVuelos() {

    return (dispatch, getState) => {
        axios.get(urlVuelosFunction())
            .then((response) => {
                console.log(response.log)
                dispatch({ type: SHOW_VUELOS, payload: response.data })
            })
    }

}

/**
 * Carga la lista de reservas por archivo json
 */
export function showReservas() {

    return (dispatch, getState) => {
        axios.get(urlVuelosFunction())
            .then((response) => {
                console.log(response.log)
                dispatch({ type: SHOW_RESERVAS, payload: response.data })
            })
    }

}