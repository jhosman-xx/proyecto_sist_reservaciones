import { SHOW_RESERVAS } from '../actions'

const initialState = {
    list: []
}

export function showVuelos(state = initialState, action) {
    
    switch (action.type) {
        case SHOW_RESERVAS:
            return Object.assign({}, state, {list: action.payload})
        default:
            return state 
    }
    
}
