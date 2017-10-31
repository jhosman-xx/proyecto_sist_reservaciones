import { combineReducers } from 'redux';
import { showUsers } from './users'
import { showVuelos } from './vuelos'


// Reducer para usuarios
const rootReducer = combineReducers({
  user: showUsers
});

// Reducer para vuelos
const rootReducerVuelos = combineReducers({
  vuelo: showVuelos
});

export default rootReducerVuelos;
