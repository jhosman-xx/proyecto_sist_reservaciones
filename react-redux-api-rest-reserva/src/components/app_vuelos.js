import React from 'react';
import { Component } from 'react';
import { connect } from 'react-redux'
import { showVuelos } from '../actions'
import { Table } from 'react-bootstrap'

class AppVuelo extends Component {
  
  componentWillMount() {
    this.props.showVuelos()
  }
  
  renderVuelosList() {
    return this.props.vuelos.map((vuelo) => {
      return (
        <tr key={vuelo.id}>
          <td>{vuelo.id}</td>
          <td>{vuelo.origen}</td>
          <td>{vuelo.destino}</td>
          <td>{vuelo.fecha}</td>
          <td>{vuelo.hora}</td>
          <td>{vuelo.capacidad}</td>
          <td>{vuelo.disponibilidad}</td>
          <td>{vuelo.jornada}</td>
          <td>{vuelo.costo}</td>
        </tr>
      )
    })
  }
  
  render() {
    return (
      <div>
        <h2>Lista de  Vuelos</h2>
        <Table responsive>
          <thead>
            <tr>
            <th>Id</th>
            <th>origen</th>
            <th>destino</th>
            <th>fecha</th>
            <th>hora</th>
            <th>capacidad</th>
            <th>disponibilidad</th>
            <th>jornada</th>
            <th>costo</th>
            </tr>
          </thead>
          <tbody>
            { this.renderVuelosList() }
          </tbody>
        </Table>        
      </div>
    );
  }
}

function mapStateToProps(state) {
  return {
    vuelos: state.vuelo.list
  }
}

export default connect(mapStateToProps, { showVuelos })(AppVuelo)