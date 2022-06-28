import React from "react";
import styled from "styled-components";

const Container = styled.div`
  :not(:last-child) {
    margin-bottom: 50px;
  }
  width: 100%;
`;

const Content = styled.div`
  display: flex;
  justify-content: left;
  max-width: 2400px;
  flex-wrap: wrap;
  @media (max-width: 768px) {
    justify-content: space-between;
  }
`;

export const Section = ({ children }) => {
  return (
    <Container>
      <Content>{children}</Content>
    </Container>
  );
};
